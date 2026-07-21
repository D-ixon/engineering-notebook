import numpy as np
import pandas as pd

# ==========================================
# 1. THE ALGORITHM (NumPy)
# ==========================================
class LogisticRegression:
    def __init__(self, learning_rate=0.01, n_iterations=1000):
        self.learning_rate = learning_rate
        self.n_iterations = n_iterations
        self.weights = None
        self.bias = None

    def _sigmoid(self, z):
        # Clip z to prevent exponential overflow
        z = np.clip(z, -500, 500)
        return 1 / (1 + np.exp(-z))

    def fit(self, X, y):
        n_samples, n_features = X.shape

        # Initialize parameters
        self.weights = np.zeros(n_features)
        self.bias = 0

        # Gradient Descent loop
        for _ in range(self.n_iterations):
            linear_model = np.dot(X, self.weights) + self.bias
            y_predicted = self._sigmoid(linear_model)

            # Compute gradients
            dw = (1 / n_samples) * np.dot(X.T, (y_predicted - y))
            db = (1 / n_samples) * np.sum(y_predicted - y)

            # Update parameters
            self.weights -= self.learning_rate * dw
            self.bias -= self.learning_rate * db

    def predict_proba(self, X):
        linear_model = np.dot(X, self.weights) + self.bias
        return self._sigmoid(linear_model)

    def predict(self, X, threshold=0.5):
        probabilities = self.predict_proba(X)
        return np.array([1 if p >= threshold else 0 for p in probabilities])


# ==========================================
# 2. THE DATA PIPELINE (Pandas + NumPy)
# ==========================================
def train_model_from_csv(file_path, target_column_name=None):
    """
    Loads a CSV using Pandas, preprocesses it, and trains the NumPy model.
    """
    print(f"Loading dataset from '{file_path}'...")
    df = pd.read_csv(file_path)

    # 1. Clean the data: Drop rows with missing values
    initial_rows = len(df)
    df = df.dropna()
    if len(df) < initial_rows:
        print(f"Dropped {initial_rows - len(df)} rows with missing values.")

    # 2. Separate Features (X) and Target (y)
    # If target column isn't specified, assume it is the very last column
    if target_column_name:
        X_df = df.drop(columns=[target_column_name])
        y_series = df[target_column_name]
    else:
        X_df = df.iloc[:, :-1]
        y_series = df.iloc[:, -1]

    print(f"Features detected: {list(X_df.columns)}")
    print(f"Target detected: '{y_series.name}'")

    # 3. Convert Pandas DataFrame/Series to NumPy arrays for the math
    X = X_df.to_numpy(dtype=float)
    y = y_series.to_numpy(dtype=float)

    # 4. Feature Scaling (Standardization: Z = (X - u) / s)
    # Essential for Gradient Descent to converge quickly and reliably
    mean = np.mean(X, axis=0)
    std = np.std(X, axis=0)
    # Prevent division by zero if a feature has constant values
    std[std == 0] = 1 
    X_scaled = (X - mean) / std

    # 5. Train the model
    print("Training Logistic Regression model...")
    model = LogisticRegression(learning_rate=0.1, n_iterations=2000)
    model.fit(X_scaled, y)

    # 6. Evaluate on the data
    predictions = model.predict(X_scaled)
    accuracy = np.mean(predictions == y) * 100
    print(f"Training Complete! Accuracy: {accuracy:.2f}%\n")

    return model, mean, std


# ==========================================
# 3. EXECUTION & DUMMY DATA GENERATOR
# ==========================================
if __name__ == "__main__":
    # Create a quick dummy CSV file so this script runs out-of-the-box
    dummy_filename = "student_pass_data.csv"
    
    # Generating mock data: Study Hours, Sleep Hours -> Pass (1) or Fail (0)
    np.random.seed(42)
    study_hours = np.random.normal(5, 2, 100)
    sleep_hours = np.random.normal(7, 1.5, 100)
    # Higher study and moderate sleep increases chance of passing
    log_odds = -5 + (1.2 * study_hours) + (0.5 * sleep_hours)
    probabilities = 1 / (1 + np.exp(-log_odds))
    pass_exam = (probabilities > 0.5).astype(int)

    # Save to CSV using Pandas
    dummy_df = pd.DataFrame({
        'Study_Hours': study_hours,
        'Sleep_Hours': sleep_hours,
        'Passed_Exam': pass_exam
    })
    dummy_df.to_csv(dummy_filename, index=False)
    print(f"Generated mock dataset: '{dummy_filename}'\n")

    # Run the full training pipeline!
    trained_model, feature_means, feature_stds = train_model_from_csv(dummy_filename)