#include <iostream>
#include <cstdint> // Required for fixed-width types in C++

int main() {
    uint8_t pixel_brightness = 200;  // Fits easily in 0-255 range
    uint32_t user_id = 41295810;     // Large positive ID
    int32_t temperature = -15;       // Can handle negative values

    std::cout << "Brightness: " << static_cast<int>(pixel_brightness) << "\n";
    std::cout << "User ID: " << user_id << "\n";
    std::cout << "Temperature: " << temperature << " C\n";

    return 0;
}