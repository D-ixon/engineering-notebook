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
# Baseband: +/- f1, +/- f2
# Replicas around fs: fs +/- f1, fs +/- f2
# Replicas around 2fs: 2fs +/- f1, 2fs +/- f2
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

# Plotting
plt.figure(figsize=(12, 6))
markerline, stemlines, _ = plt.stem(freqs, heights, basefmt="k-", label="Impulses")

# Highlight Baseband and Replicas
plt.axvspan(-4000, 4000, color='blue', alpha=0.1, label="Baseband (-fs/2 to fs/2)")
plt.axvspan(4000, 12000, color='green', alpha=0.1, label="First Replica (around fs)")

# Formatting
plt.title(r'Frequency Spectrum of Sampled Signal: $x(t) = 5\cos(2\pi \cdot 2000t) + 3\cos(2\pi \cdot 3000t)$')
plt.xlabel('Frequency (Hz)')
plt.ylabel('Magnitude')
plt.xlim(-5000, 20000)
plt.ylim(0, 3)
plt.grid(True, linestyle='--', alpha=0.7)
plt.legend()

# Annotate specific spikes as mentioned in Solution 1
plt.annotate(f'{h1}', (2000, h1), textcoords="offset points", xytext=(0,10), ha='center')
plt.annotate(f'{h2}', (3000, h2), textcoords="offset points", xytext=(0,10), ha='center')

plt.show()