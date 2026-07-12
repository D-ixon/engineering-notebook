import plotly.graph_objects as go
import numpy as np

X = np.linspace(-5, 5, num=100)

mu = 0
sigma = 1
st_dev_square = sigma ** 2

distance_squared = np.square(X - mu)
num = 2 * st_dev_square

kern = np.exp(-distance_squared/ num)

