import plotly.graph_objects as go
import numpy as np

X = np.linspace(-5, 5, num=100)

mu = 0
sigma = 1
st_dev_square = sigma ** 2

distance_squared = np.square(X - mu)
denominator = 2 * st_dev_square

gaussian_shape = np.exp(-distance_squared/ denominator)

gauss = go.Figure()
gauss.add_trace(go.Scatter(x=X, y=gaussian_shape, mode='lines'))
gauss.update_layout(title = "Gaussian (Normal) Distribution", xaxis_title = "X values", yaxis_title = "the kernel")
gauss.show()