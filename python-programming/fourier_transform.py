import numpy as np
import matplotlib.pyplot as plt

def main():
    # 1. Get user input to build the signal
    print("Let's create a signal by combining two sine waves.")
    try:
        f1 = float(input("Enter the first frequency (in Hz, e.g., 20): "))
        f2 = float(input("Enter the second frequency (in Hz, e.g., 80): "))
    except ValueError:
        print("Invalid input. Defaulting to 20 Hz and 80 Hz.")
        f1, f2 = 20.0, 80.0

    # 2. Set up the sampling rate and time vector
    fs = 1000  # Sampling frequency in Hz (how many data points per second)
    t_max = 1.0 # Duration of the signal in seconds
    t = np.linspace(0, t_max, int(fs * t_max), endpoint=False)

    # 3. Generate the time-domain signal
    # Mix the two user frequencies and add some random background noise
    signal = np.sin(2 * np.pi * f1 * t) + 0.5 * np.sin(2 * np.pi * f2 * t)
    noise = 0.5 * np.random.normal(size=t.shape)
    signal += noise

    # 4. Compute the Fast Fourier Transform (FFT)
    n = len(signal)
    fft_values = np.fft.fft(signal)             # Computes the complex Fourier transform
    frequencies = np.fft.fftfreq(n, d=1/fs)     # Computes the frequency bins

    # 5. Clean up the FFT data for plotting
    # The FFT output is mirrored, so we only need the first half (positive frequencies)
    half_n = n // 2
    positive_frequencies = frequencies[:half_n]
    
    # Normalize the amplitude magnitude so it matches the input scale
    fft_magnitude = np.abs(fft_values[:half_n]) * (2.0 / n)

    # 6. Plotting with Matplotlib
    plt.figure(figsize=(10, 6))

    # Top plot: Time Domain (zoomed in to the first 0.25 seconds to see the waves)
    plt.subplot(2, 1, 1)
    window = int(fs * 0.25)
    plt.plot(t[:window], signal[:window], color='blue')
    plt.title('Time Domain Signal (User Input + Noise)')
    plt.xlabel('Time [seconds]')
    plt.ylabel('Amplitude')
    plt.grid(True)

    # Bottom plot: Frequency Domain (Fourier Transform)
    plt.subplot(2, 1, 2)
    plt.plot(positive_frequencies, fft_magnitude, color='red')
    plt.title('Frequency Domain (FFT)')
    plt.xlabel('Frequency [Hz]')
    plt.ylabel('Magnitude')
    
    # Zoom the x-axis to nicely frame the user's frequencies
    plt.xlim(0, max(f1, f2) + 50)
    plt.grid(True)

    # Display the plots
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main()