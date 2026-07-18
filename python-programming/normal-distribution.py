import plotly.graph_objects as go
import numpy as np

#sliders for mu and sigma
#shade area under the curve 

#making it 3D using axes for x = variables, y = mean(μ), and z = the probability density function (PDF)

X = np.linspace(-5, 5, num=100)
mus = np.linspace(-5, 5, num=100)
two_pi = np.pi * 2
sigma = 1

X_grid, mu_grid = np.meshgrid(X, mus)

def gaussian_pdf(x, mu, sigma):
    sigma_square = sigma ** 2
    denominator = 2 * sigma_square
    distance_squared = np.square(x - mu)
    gaussian_shape = np.exp(-distance_squared / denominator)
    normalization_constant = 1 / (sigma * np.sqrt(two_pi))
    probability_density = normalization_constant * gaussian_shape

    return probability_density


Z = gaussian_pdf(X_grid, mu_grid, sigma)


gauss = go.Figure()
gauss.add_trace(go.Surface(x = X_grid, y = mu_grid, z = Z, name = (f" 𝜎 = {sigma}")))
gauss.update_layout(title = "Gaussian (Normal) Distribution", xaxis_title = "X values", yaxis_title = "gaussian pdf")
gauss.show()