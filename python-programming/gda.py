import numpy as np

class GaussianDiscriminantAnalysis:
    def __init__(self, shared_covariance=False):
        """
        Args:
            shared_covariance (bool): If True, computes a single covariance matrix 
                                      for all classes (Linear boundary). 
                                      If False, computes separate covariances 
                                      (Quadratic boundary).
        """
        self.shared_covariance = shared_covariance
        self.classes = None
        self.priors = {}
        self.means = {}
        self.covs = {}

    def fit(self, X, y):
        """Fit the GDA model to training data."""
        self.classes = np.unique(y)
        n_samples, n_features = X.shape

        if self.shared_covariance:
            shared_cov = np.zeros((n_features, n_features))

        # Calculate means, priors, and covariances for each class
        for c in self.classes:
            X_c = X[y == c]
            
            # Prior probability P(y=c)
            self.priors[c] = X_c.shape[0] / n_samples
            
            # Mean vector for class c: \mu_c
            self.means[c] = np.mean(X_c, axis=0)

            if self.shared_covariance:
                # Accumulate scatter matrix for pooled covariance
                shared_cov += np.cov(X_c, rowvar=False, bias=False) * (X_c.shape[0] - 1)
            else:
                # Class-specific covariance matrix: \Sigma_c
                # Adding a tiny jitter (1e-6) to the diagonal prevents singular matrix errors
                self.covs[c] = np.cov(X_c, rowvar=False, bias=True) + 1e-6 * np.eye(n_features)

        # Finalize shared covariance matrix if requested
        if self.shared_covariance:
            shared_cov /= (n_samples - len(self.classes))
            for c in self.classes:
                self.covs[c] = shared_cov + 1e-6 * np.eye(n_features)

    def _compute_log_likelihood(self, X, mean, cov):
        """Computes the log of the Gaussian PDF for numerical stability."""
        cov_inv = np.linalg.inv(cov)
        cov_det = np.linalg.det(cov)
        
        diff = X - mean
        
        # Vectorized computation of (x - mu)^T * Sigma^-1 * (x - mu)
        # diff @ cov_inv -> shape (N, d)
        # Multiplying element-wise by diff and summing over axis 1 gives the quadratic term
        mahalanobis_term = np.sum(np.dot(diff, cov_inv) * diff, axis=1)
        
        # Log likelihood formula (omitting the -d/2 log(2pi) constant as it drops out in comparison)
        log_likelihood = -0.5 * np.log(cov_det) - 0.5 * mahalanobis_term
        return log_likelihood

    def predict(self, X):
        """Predict the class labels for input data X."""
        # Matrix to store log(P(X|y=c) * P(y=c))
        log_posteriors = np.zeros((X.shape[0], len(self.classes)))

        for idx, c in enumerate(self.classes):
            # log(P(y=c))
            log_prior = np.log(self.priors[c])
            
            # log(P(X|y=c))
            log_likelihood = self._compute_log_likelihood(X, self.means[c], self.covs[c])
            
            # log(P(X|y=c) * P(y=c))
            log_posteriors[:, idx] = log_likelihood + log_prior

        # Return the class with the highest log posterior probability
        return self.classes[np.argmax(log_posteriors, axis=1)]