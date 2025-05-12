package com.evidencia.application.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.evidencia.application.ui.theme.MediumGray

@Composable
fun Footer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(MediumGray)
            .padding(vertical = 24.dp, horizontal = 16.dp)
    ) {
        // Eslogan
        Text(
            text = "Productos de cuidado personal",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "¡Una solución sencilla y eficaz!",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp),
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contacto
        Text(
            text = "Contáctanos",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Email: company@mail.com\nTel: +57 300 123 4567",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Derechos reservados
        Text(
            text = "© 2025 Todos los derechos reservados",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
