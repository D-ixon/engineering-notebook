import plotly.graph_objects as go
import numpy as np

#sliders for mu and sigma
#shade area under the curve 

X = np.linspace(-5, 5, num=100)

mus = [-3, 0, 2]
two_pi = np.pi * 2
sigmas = [0.5, 1, 2]


gauss = go.Figure()

for sigma in sigmas:

    sigma_square = sigma ** 2 

    denominator = 2 * sigma_square

    for mu in mus:

        distance_squared = np.square(X - mu)

        normalization_constant = 1 / (sigma * np.sqrt(two_pi))

        gaussian_shape = np.exp(-distance_squared / denominator)

        probability_density = normalization_constant * gaussian_shape

        gauss.add_trace(go.Scatter(x=X, y=probability_density, mode='lines', name=(f" 𝜎 = {sigma}"), line=dict(color='red')))


gauss.update_layout(title = "Gaussian (Normal) Distribution", xaxis_title = "X values", yaxis_title = "the kernel")
gauss.show()