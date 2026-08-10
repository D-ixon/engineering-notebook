import numpy as np
import matplotlib.pyplot as plt
import matplotlib.animation as animation

duration = 9.0         
fps = 30                
total_frames = int(duration * fps)

t_continuous = np.linspace(0, duration, 1000)

analog_signal = np.sin(2 * np.pi * 1 * t_continuous) + 0.5 * np.sin(2 * np.pi * 3 * t_continuous)

fs = 5 
dt = 1.0 / fs
sample_times = np.arange(0, duration, dt)
sample_values = np.sin(2 * np.pi * 1 * sample_times) + 0.5 * np.sin(2 * np.pi * 3 * sample_times)

fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(10, 7), sharex=True)
fig.suptitle('Sample and Hold (S&H) Simulation', fontsize=14, fontweight='bold')

ax1.plot(t_continuous, analog_signal, 'b-', label='Continuous Analog Signal', alpha=0.6)
stem_line, = ax1.plot([], [], 'ro-', label='Sampling Instants', markersize=6)
ax1.set_ylabel('Amplitude')
ax1.set_ylim(-2, 2)
ax1.grid(True, linestyle='--', alpha=0.5)
ax1.legend(loc='upper right')

hold_line, = ax2.plot([], [], 'g-', linewidth=2, label='Sample-and-Hold Output')
ax2.set_xlabel('Time (s)')
ax2.set_ylabel('Amplitude')
ax2.set_xlim(0, duration)
ax2.set_ylim(-2, 2)
ax2.grid(True, linestyle='--', alpha=0.5)
ax2.legend(loc='upper right')

plt.tight_layout()

def update(frame):

    current_time = (frame / total_frames) * duration
    
    active_indices = sample_times <= current_time
    t_samples_so_far = sample_times[active_indices]
    v_samples_so_far = sample_values[active_indices]
    
    stem_line.set_data(t_samples_so_far, v_samples_so_far)
    
    if len(t_samples_so_far) > 0:
        t_hold = []
        v_hold = []
        
        for i in range(len(t_samples_so_far)):
            start_t = t_samples_so_far[i]

            end_t = t_samples_so_far[i + 1] if i + 1 < len(t_samples_so_far) else current_time
            
            t_hold.extend([start_t, end_t])
            v_hold.extend([v_samples_so_far[i], v_samples_so_far[i]])
            
        hold_line.set_data(t_hold, v_hold)
    
    return stem_line, hold_line


ani = animation.FuncAnimation(
    fig, update, frames=total_frames, interval=5000/fps, blit=True, repeat=True
)

plt.show()