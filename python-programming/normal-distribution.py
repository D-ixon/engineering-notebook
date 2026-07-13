import plotly.graph_objects as go
import numpy as np

#sliders for mu and sigma
#shade area under the curve 

X = np.linspace(-5, 5, num=100)
    
mu = 0
sigma = 1
st_dev_square = sigma ** 2   
di_pi = np.pi * 2

distance_squared = np.square(X - mu)
denominator = 2 * st_dev_square
gaussian_shape = np.exp(-distance_squared/ denominator)

normalization_constant = 1 / (sigma * np.sqrt(di_pi))

full_pdf = normalization_constant * gaussian_shape

gauss = go.Figure()
gauss.add_trace(go.Scatter(x=X, y=full_pdf, mode='lines', name='Gaussian Distribution', line=dict(color='blue')))
gauss.update_layout(title = "Gaussian (Normal) Distribution", xaxis_title = "X values", yaxis_title = "the kernel")
gauss.show()