import numpy as np
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation
import seaborn as sns

# Set a smooth, modern visual theme
sns.set_theme(style="darkgrid")

# 1. Define the landscape (The Bowl)
def f(x):
    # A polynomial that forms a bowl and a clear absolute minimum
    return x**3 + x**2 - 0.5 * x

def df(x):
    # The derivative (slope) tells us how steep the bowl is at any point x
    return 0.4 * x**3 + 0.2 * x - 0.5

# 2. Simulation Parameters
learning_rate = 0.01  # How strongly gravity pulls it down the slope
momentum = 0.1      # How much speed it retains (inertia). 0 = no momentum, 1 = no friction
num_steps = 1200

# Initial conditions
x_curr = 3.0          # Drop the ball high up on the right side
v_curr = 0.0          # Initial velocity is zero
trajectory = []       # Store positions for the animation

# 3. Run the Physics Simulation
for _ in range(num_steps):
    trajectory.append(x_curr)
    grad = df(x_curr)
    
    # Velocity is a mix of previous speed (momentum) and the new slope (gravity)
    v_curr = momentum * v_curr - learning_rate * grad
    
    # Move the ball based on its velocity
    x_curr += v_curr

# 4. Set up the Visualization
fig, ax = plt.subplots(figsize=(10, 6))
x_vals = np.linspace(-3.5, 3.5, 500)
y_vals = f(x_vals)

# Draw the landscape
ax.plot(x_vals, y_vals, color='#2ab0ff', lw=3, label='Surface')
ax.set_title("Ball Rolling to Absolute Minimum", fontsize=16, fontweight='bold')
ax.set_xlabel("Position (x)")
ax.set_ylabel("Height (y)")

# Create the ball object (starts empty)
ball, = ax.plot([], [], 'o', color='#ff3366', markersize=15, zorder=5, label='Ball')
ax.legend()

# 5. Animation Functions
def init():
    ball.set_data([], [])
    return ball,

def update(frame):
    # Get the ball's position at the current frame
    x = trajectory[frame]
    y = f(x)
    # Update the visual ball marker
    ball.set_data([x], [y])
    return ball,

# 6. Run the Animation
# blit=True ensures only the ball is redrawn, making the animation much smoother
ani = FuncAnimation(
    fig, 
    update, 
    frames=num_steps, 
    init_func=init, 
    blit=True, 
    interval=40 # 40ms per frame = 25 FPS
)

# Note: If you want to save this to a file, you can uncomment the line below 
# (requires ffmpeg to be installed on your system)
# ani.save('rolling_ball.mp4', fps=30)

# Display the interactive window
plt.show()