import plotly.graph_objects as go
import numpy as np

#sliders for mu and sigma
#shade area under the curve 

X = np.linspace(-5, 5, num=100)

mus = [-3, 0, 2]
two_pi = np.pi * 2
sigmas = [0.5, 1, 2]

def gaussian_pdf(x, mu, sigma):
    sigma_square = sigma ** 2
    denominator = 2 * sigma_square
    distance_squared = np.square(x - mu)
    gaussian_shape = np.exp(-distance_squared / denominator)
    normalization_constant = 1 / (sigma * np.sqrt(two_pi))
    probability_density = normalization_constant * gaussian_shape

    return probability_density

gauss = go.Figure()

for sigma in sigmas:
    
    for mu in mus:

        probability_density = gaussian_pdf(X, mu, sigma)

        gauss.add_trace(go.Scatter(x=X, y=probability_density, mode='lines', name=(f" 𝜎, μ = {sigma, mu}")))


gauss.update_layout(title = "Gaussian (Normal) Distribution", xaxis_title = "X values", yaxis_title = "the kernel")
gauss.show()