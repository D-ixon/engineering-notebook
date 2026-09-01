import numpy as np

# ==========================================
# 1. Linear Regression (Gradient Descent)
# ==========================================
def linear_regression_gd(X, y, lr=0.01, epochs=1000):
    
    m, n = X.shape
    theta = np.zeros((n, 1))
    
    for _ in range(epochs):
        predictions = np.dot(X, theta)
        errors = predictions - y
        gradients = (1 / m) * np.dot(X.T, errors)
        theta -= lr * gradients
        
    return theta


# ==========================================
# 2. Logistic Regression (Gradient Descent)
# ==========================================
def sigmoid(z):

    return 1 / (1 + np.exp(-np.clip(z, -500, 500)))

def logistic_regression_gd(X, y, lr=0.01, epochs=1000):
    m, n = X.shape
    theta = np.zeros((n, 1))
    
    for _ in range(epochs):
        h = sigmoid(np.dot(X, theta))
        errors = h - y
        # Gradient of Cross-Entropy: (1/m) * X^T * (sigmoid(X*theta) - y)
        gradients = (1 / m) * np.dot(X.T, errors)
        theta -= lr * gradients
        
    return theta


# ==========================================
# 3. Gaussian Discriminant Analysis (GDA)
# ==========================================
def gda_train(X, y):
    """
    Estimates parameters for GDA (assumes continuous features, binary classes).
    Returns class prior (phi), means for class 0 and 1, and shared covariance matrix.
    """
    m, n = X.shape
    y = y.reshape(-1)
    
    # Prior phi = P(y = 1)
    phi = np.mean(y)
    
    # Means mu_0 and mu_1
    mu_0 = np.mean(X[y == 0], axis=0)
    mu_1 = np.mean(X[y == 1], axis=0)
    
    # Shared covariance matrix Sigma
    sigma = np.zeros((n, n))
    for i in range(m):
        mu = mu_1 if y[i] == 1 else mu_0
        x_i = X[i].reshape(-1, 1)
        mu = mu.reshape(-1, 1)
        sigma += np.dot((x_i - mu), (x_i - mu).T)
        
    sigma /= m
    return phi, mu_0, mu_1, sigma


# ==========================================
# 4. Bayes' Theorem (Discrete/General Form)
# ==========================================
def bayes_theorem(p_y, p_x_given_y, p_x):
    """
    Calculates posterior probability using Bayes' Theorem:
    P(Y | X) = [ P(X | Y) * P(Y) ] / P(X)
    """
    # Element-wise calculation for conditional probability
    p_y_given_x = (p_x_given_y * p_y) / p_x
    return p_y_given_x
