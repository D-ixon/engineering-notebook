import numpy as np
import matplotlib.pyplot as plt

def main():
    print("--- Signal Generator & FFT Analyzer ---")
    try:
        f1 = float(input("Enter Frequency 1 (in Hz, e.g., 20): "))
        a1 = float(input("Enter Amplitude 1 (e.g., 2.5): "))
        
        f2 = float(input("Enter Frequency 2 (in Hz, e.g., 80): "))
        a2 = float(input("Enter Amplitude 2 (e.g., 1.0): "))
    except ValueError:
        print("Invalid input. Using default values.")
        f1, a1 = 20.0, 2.5
        f2, a2 = 80.0, 1.0

    # Sampling Setup
    fs = 1000          # Sampling rate (samples per second)
    duration = 1.0     # Signal length in seconds
    t = np.linspace(0, duration, int(fs * duration), endpoint=False)

    # Combine signals using specified amplitudes: A * sin(2 * pi * f * t)
    signal1 = a1 * np.sin(2 * np.pi * f1 * t)
    signal2 = a2 * np.sin(2 * np.pi * f2 * t)
    noise = 0.3 * np.random.normal(size=t.shape) # Minor background noise
    
    combined_signal = signal1 + signal2 + noise

    # Fast Fourier Transform (FFT)
    n = len(combined_signal)
    fft_values = np.fft.fft(combined_signal)
    frequencies = np.fft.fftfreq(n, d=1/fs)

    # Extract positive frequencies and scale amplitudes correctly
    half_n = n // 2
    pos_frequencies = frequencies[:half_n]
    
    # Absolute value gets magnitude; multiply by 2/N to convert raw FFT energy to original amplitude units
    fft_amplitude = np.abs(fft_values[:half_n]) * (2.0 / n)

    # Plotting
    plt.figure(figsize=(10, 6))

    # Plot 1: Time Domain
    plt.subplot(2, 1, 1)
    window = int(fs * 0.25) # Display first 0.25s
    plt.plot(t[:window], combined_signal[:window], color='navy')
    plt.title('Time Domain: Combined Signal')
    plt.xlabel('Time [s]')
    plt.ylabel('Amplitude')
    plt.grid(True)

    # Plot 2: Frequency Domain
    plt.subplot(2, 1, 2)
    plt.plot(pos_frequencies, fft_amplitude, color='darkred')
    plt.title('Frequency Domain: Magnitude Spectrum')
    plt.xlabel('Frequency [Hz]')
    plt.ylabel('Amplitude')
    
    # Frame graph to focus around inputs
    max_freq = max(f1, f2)
    max_amp = max(a1, a2)
    plt.xlim(0, max_freq + 40)
    plt.ylim(0, max_amp * 1.2)
    plt.grid(True)

    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()