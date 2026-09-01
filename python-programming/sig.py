import matplotlib.pyplot as plt
import numpy as np

# Parameters for Example 1
f1 = 2000  # Hz
f2 = 3000  # Hz
A1 = 5     # Original amplitude
A2 = 3     # Original amplitude
fs = 8000  # Sampling frequency (8 kHz)

# Euler's Identity: Heights are half of original amplitudes
h1 = A1 / 2
h2 = A2 / 2

# Frequencies to plot (Baseband + Replicas at fs and 2fs)
multiples = [0, fs, 16000]
freqs = []
heights = []

for m in multiples:
    # Add spikes for the 2000Hz component
    freqs.extend([m - f1, m + f1])
    heights.extend([h1, h1])
    
    # Add spikes for the 3000Hz component
    freqs.extend([m - f2, m + f2])
    heights.extend([h2, h2])

# Combine duplicate frequencies for clean stem rendering
freq_dict = {}
for f, h in zip(freqs, heights):
    freq_dict[f] = freq_dict.get(f, 0) + h

unique_freqs = np.array(list(freq_dict.keys()))
unique_heights = np.array(list(freq_dict.values()))

# Sort frequencies for proper stem line rendering
sort_idx = np.argsort(unique_freqs)
unique_freqs = unique_freqs[sort_idx]
unique_heights = unique_heights[sort_idx]

# Plotting
plt.figure(figsize=(12, 6))

# Highlight Baseband and Replicas first so stems sit on top
plt.axvspan(-4000, 4000, color='blue', alpha=0.1, label="Baseband (-fs/2 to fs/2)")
plt.axvspan(4000, 12000, color='green', alpha=0.1, label="First Replica (around fs)")

# Stem plot with fixed formatting
markerline, stemlines, baseline = plt.stem(
    unique_freqs, unique_heights, basefmt="k-", label="Impulses"
)

# Formatting
plt.title(r'Frequency Spectrum of Sampled Signal: $x(t) = 5\cos(2\pi \cdot 2000t) + 3\cos(2\pi \cdot 3000t)$')
plt.xlabel('Frequency (Hz)')
plt.ylabel('Magnitude')
plt.xlim(-5000, 20000)
plt.ylim(0, 3.5)  # Expanded y-limit to avoid clipping annotations
plt.grid(True, linestyle='--', alpha=0.7)
plt.legend()

# Annotate all impulse spikes automatically
for f, h in zip(unique_freqs, unique_heights):
    if -5000 <= f <= 20000:  # Only annotate visible spikes
        plt.annotate(
            f'{h:.1f}', 
            (f, h), 
            textcoords="offset points", 
            xytext=(0, 6), 
            ha='center', 
            fontsize=9
        )

plt.tight_layout()
plt.show()