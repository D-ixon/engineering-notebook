import numpy as np
import plotly.graph_objects as go

X = np.linspace(-5, 5, num=100)

Y = X ** 2

fig = go.Figure()
fig.add_trace(go.Scatter(x=X, y=Y, mode='lines', name='y = x^2'))
fig.update_layout(title='Normal Distribution', xaxis_title='X', yaxis_title='Y', showlegend=True)
fig.show()