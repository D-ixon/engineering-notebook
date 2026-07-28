# ===============================================================
# 🍉 Interactive Fruit Clustering Demo – Hierarchical & DBSCAN
# Author: Dr. Isaac Osei Nyantakyi
# Topic: Unsupervised Learning - Clustering Visualization
# ===============================================================

import streamlit as st
import pandas as pd
import numpy as np

from sklearn.preprocessing import LabelEncoder, MinMaxScaler
from sklearn.cluster import AgglomerativeClustering, DBSCAN

import plotly.express as px
import matplotlib.pyplot as plt
import scipy.cluster.hierarchy as sch

import numpy as np
from sklearn.metrics import pairwise_distances

def divisive_with_dendrogram(X):
    """
    Performs DIANA-style divisive clustering AND constructs a linkage matrix
    so we can plot a dendrogram.
    """
    n = X.shape[0]
    clusters = {0: list(range(n))}    # start with one cluster
    next_cluster_id = 1               # new cluster ids
    linkage_rows = []                 # rows for scipy linkage matrix

    def recursive_split(cluster_id, elements):
        nonlocal next_cluster_id, linkage_rows

        if len(elements) <= 1:
            return

        # compute distances
        centroid = X[elements].mean(axis=0)
        distances = np.linalg.norm(X[elements] - centroid, axis=1)

        # find the farthest point
        farthest_index = elements[np.argmax(distances)]

        # create two subclusters
        cluster_a = []
        cluster_b = []

        for idx in elements:
            if np.linalg.norm(X[idx] - X[farthest_index]) < np.linalg.norm(X[idx] - centroid):
                cluster_a.append(idx)
            else:
                cluster_b.append(idx)

        # assign new cluster IDs
        cid1 = next_cluster_id
        cid2 = next_cluster_id + 1
        next_cluster_id += 2

        clusters[cid1] = cluster_a
        clusters[cid2] = cluster_b

        # distance between subclusters (diameter of parent)
        if len(elements) > 1:
            diameter = pairwise_distances(X[elements]).max()
        else:
            diameter = 0

        linkage_rows.append([cid1, cid2, diameter, len(elements)])

        # recursively split
        recursive_split(cid1, cluster_a)
        recursive_split(cid2, cluster_b)

    # start recursion
    recursive_split(0, clusters[0])

    # convert linkage list to numpy array sorted by cluster size
    linkage_matrix = np.array(linkage_rows)

    return linkage_matrix

# ---------------------------------------------------------------
# 1. DATASET
# ---------------------------------------------------------------
def load_fruit_data():
    data = {
        'Fruit': ['Apple', 'Banana', 'Lemon', 'Watermelon', 'Grapes', 'Mango', 'Orange', 'Strawberry'],
        'Color': ['Red', 'Yellow', 'Yellow', 'Green', 'Green', 'Yellow', 'Orange', 'Red'],
        'Size': ['Medium', 'Long', 'Small', 'Large', 'Small', 'Medium', 'Medium', 'Small'],
        'Sweetness': ['Medium', 'High', 'Low', 'Medium', 'High', 'High', 'Medium', 'High'],
        'Weight': [180, 120, 70, 3000, 5, 250, 160, 15]
    }
    return pd.DataFrame(data)


df = load_fruit_data()

# ---------------------------------------------------------------
# 2. STREAMLIT LAYOUT
# ---------------------------------------------------------------
st.title("🍎 Unsupervised Learning: Hierarchical & Density-Based Clustering")

st.write("""
This app lets you explore **Hierarchical Clustering** and **Density-Based Clustering (DBSCAN)** 
on a simple *fruit* dataset.

- Choose the method in the sidebar.
- Select features.
- Adjust parameters.
- See how the clusters change.
""")

st.sidebar.header("⚙️ Settings")
method = st.sidebar.radio(
    "Choose clustering method:",
    ["Hierarchical Clustering", "Density-Based (DBSCAN)"]
)

# ---------------------------------------------------------------
# 3. FEATURE SELECTION & ENCODING
# ---------------------------------------------------------------
all_features = ['Color', 'Size', 'Sweetness', 'Weight']
features = st.sidebar.multiselect(
    "Select features to use for clustering:",
    all_features,
    default=['Color', 'Size', 'Sweetness']
)

if len(features) < 2:
    st.warning("Please select at least 2 features for meaningful visualization.")
    st.stop()

df_encoded = df.copy()
le = LabelEncoder()

# Encode categorical features
for col in ['Color', 'Size', 'Sweetness']:
    df_encoded[col] = le.fit_transform(df_encoded[col])

# Normalize selected features
scaler = MinMaxScaler()
X = scaler.fit_transform(df_encoded[features])

# For plotting, we’ll use the first 2 selected features as axes
x_feat, y_feat = features[0], features[1]

## ---------------------------------------------------------------
# 4. HIERARCHICAL CLUSTERING (Agglomerative + Divisive)
# ---------------------------------------------------------------
if method == "Hierarchical Clustering":
    st.subheader("🌳 Hierarchical Clustering")

    # Choose algorithm level
    algo_choice = st.sidebar.radio(
        "Clustering approach:",
        ["Agglomerative (Bottom-Up)", "Divisive (Top-Down)"]
    )

    # Feature selection
    n_clusters = st.sidebar.slider("Number of clusters", 2, min(6, len(df)), 3)
    linkage = st.sidebar.selectbox(
        "Linkage method (for Agglomerative)",
        ["ward", "complete", "average", "single"]
    )

    # -------------- AGGLOMERATIVE CLUSTERING -------------------
    if algo_choice == "Agglomerative (Bottom-Up)":

        model = AgglomerativeClustering(
            n_clusters=n_clusters,
            metric="euclidean",
            linkage=linkage
        )
        labels = model.fit_predict(X)
        df['Cluster'] = labels.astype(str)

        # Scatter plot
        st.markdown("### 📊 Agglomerative Cluster Scatter Plot")
        fig_scatter = px.scatter(
            df,
            x=x_feat,
            y=y_feat,
            color='Cluster',
            text='Fruit',
            size='Weight',
            title=f"Agglomerative Clustering ({linkage}, K={n_clusters})",
        )
        fig_scatter.update_traces(textposition='top center')
        st.plotly_chart(fig_scatter, use_container_width=True)

        # Dendrogram
        st.markdown("### 🌲 Dendrogram")
        Z = sch.linkage(X, method=linkage)
        fig, ax = plt.subplots(figsize=(8, 4))
        sch.dendrogram(Z, labels=df['Fruit'].values, leaf_rotation=45)
        ax.set_ylabel("Distance")
        ax.set_title("Agglomerative Dendrogram")
        st.pyplot(fig)

        st.dataframe(df[['Fruit'] + features + ['Cluster']])

    # -------------- DIVISIVE (TOP-DOWN) CLUSTERING --------------
    else:
        st.subheader("🌿 Divisive Clustering (Top-Down)")

        from sklearn.metrics import pairwise_distances


        def divisive_clustering(X, k):
            clusters = [np.arange(X.shape[0])]

            while len(clusters) < k:
                # find widest cluster
                diameters = [pairwise_distances(X[c]).max() if len(c) > 1 else 0
                             for c in clusters]
                idx = np.argmax(diameters)
                cluster_to_split = clusters.pop(idx)

                centroid = X[cluster_to_split].mean(axis=0)
                distances = np.linalg.norm(X[cluster_to_split] - centroid, axis=1)
                farthest_idx = cluster_to_split[np.argmax(distances)]

                c1, c2 = [], []
                for i in cluster_to_split:
                    if np.linalg.norm(X[i] - X[farthest_idx]) < np.linalg.norm(X[i] - centroid):
                        c1.append(i)
                    else:
                        c2.append(i)

                clusters.append(np.array(c1))
                clusters.append(np.array(c2))

            labels = np.zeros(X.shape[0], dtype=int)
            for cluster_id, idxs in enumerate(clusters):
                labels[idxs] = cluster_id

            return labels


        labels = divisive_clustering(X, n_clusters)
        df['Cluster'] = labels.astype(str)

        # Update categorical features to numeric for plotting
        for col in ['Color', 'Size', 'Sweetness']:
            df[col] = df_encoded[col]

        # Scatter plot
        st.markdown("### 📊 Divisive Cluster Scatter Plot")
        fig_div = px.scatter(
            df,
            x=x_feat,
            y=y_feat,
            color='Cluster',
            text='Fruit',
            size='Weight',
            title=f"Divisive Clustering (K={n_clusters})",
            color_discrete_sequence=px.colors.qualitative.Bold
        )
        fig_div.update_traces(textposition='top center')
        st.plotly_chart(fig_div, use_container_width=True)

        # Dataframe
        st.markdown("### 🔍 Cluster Assignments (Divisive)")
        st.dataframe(df[['Fruit'] + features + ['Cluster']])
        st.markdown("### 🌲 Divisive Dendrogram")

        
        st.info("""
        **Divisive Clustering Notes:**
        • Starts as ONE large cluster, splits recursively.
        • Opposite of agglomerative.
        • Often gives clean global separation for small datasets.
        """)



# ---------------------------------------------------------------
# 5. DENSITY-BASED CLUSTERING (DBSCAN)
# ---------------------------------------------------------------
elif method == "Density-Based (DBSCAN)":
    st.subheader("🧪 Density-Based Clustering (DBSCAN)")

    st.sidebar.markdown("### DBSCAN Parameters")
    eps = st.sidebar.slider(
        "eps (neighborhood radius)",
        0.05, 1.5, 0.4, 0.05,
        help="Maximum distance for two points to be considered neighbors (after scaling)."
    )
    min_samples = st.sidebar.slider(
        "min_samples (minimum points per dense region)",
        2, 6, 3,
        help="Minimum number of points required to form a dense region."
    )

    dbscan = DBSCAN(eps=eps, min_samples=min_samples)
    db_labels = dbscan.fit_predict(X)

    df['Cluster'] = db_labels
    df['Cluster_str'] = df['Cluster'].astype(str)
    # Mark noise points
    df['Label_Display'] = df['Cluster'].apply(lambda x: "Noise" if x == -1 else f"Cluster {x}")

    st.markdown("### 📊 Cluster Scatter Plot (DBSCAN)")
    fig_db = px.scatter(
        df,
        x=x_feat,
        y=y_feat,
        color='Label_Display',
        text='Fruit',
        size='Weight',
        title=f"DBSCAN Clustering (eps={eps}, min_samples={min_samples})",
    )
    fig_db.update_traces(textposition='top center')
    st.plotly_chart(fig_db, use_container_width=True)

    st.markdown("### 🔍 Cluster & Noise Summary")
    st.dataframe(df[['Fruit'] + features + ['Cluster']])

    n_clusters = len(set([c for c in db_labels if c != -1]))
    n_noise = np.sum(db_labels == -1)

    st.write(f"**Number of clusters (excluding noise):** {n_clusters}")
    st.write(f"**Number of noise points:** {n_noise}")

    st.markdown("""
    **Teaching notes / interpretation:**
    - DBSCAN finds clusters as *dense regions* separated by low-density areas.
    - Points labeled `-1` are considered **noise / outliers**.
    - Increasing `eps` makes clusters **bigger** and can merge them.
    - Increasing `min_samples` makes it **harder** for a region to be considered dense, often creating more noise.
    """)

# ---------------------------------------------------------------
# 6. STUDENT INTERACTION
# ---------------------------------------------------------------
st.markdown("---")
st.subheader("🧑🏽‍🎓 Your Turn: Describe Your Own Clusters")
st.write("Before looking at the algorithm’s clusters, how would **you** group these fruits based on the same features?")

student_input = st.text_area(
    "Write your grouping (e.g., Group 1: Apple, Mango, Banana; Group 2: Lemon, Orange; ...)",
    height=100
)

if student_input.strip():
    st.success("Nice! Now compare your own grouping with the clusters shown above. Where do they match or differ?")

