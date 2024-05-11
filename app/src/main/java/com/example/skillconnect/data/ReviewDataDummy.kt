package com.example.skillconnect.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person

val reviews = listOf(
    Review(
        Icons.Filled.Person, // Placeholder image vector
        "John Doe",
        4.5f,
        "Very impressed with the service. The freelancer was highly skilled and delivered the project on time and within budget. I highly recommend them!"
    ),
    Review(
        Icons.Filled.Person, // Placeholder image vector
        "Jane Smith",
        5.0f,
        "Excellent communication and top-notch work! I will definitely be using this freelancer again for future projects."
    ),
    Review(
        Icons.Filled.Person, // Placeholder image vector
        "Alex Miller",
        3.8f,
        "The freelancer was good, but the project took a little longer than expected. Overall, I'm satisfied with the results."
    ),
    Review(
        Icons.Filled.Person, // Placeholder image vector
        "Olivia Jones",
        4.2f,
        "This freelancer went above and beyond to meet my expectations. They were very creative and provided valuable insights throughout the project. Highly recommended!"
    ),
    Review( // Review with more than 3 lines
        Icons.Filled.Person, // Placeholder image vector
        "Michael Brown",
        4.7f,
        "I'm incredibly happy with the freelancer's work. They were not only skilled but also very patient and understanding throughout the project. They took the time to answer all my questions and address any concerns I had. I would definitely use them again and highly recommend them to anyone looking for a reliable and talented freelancer."
    )
)