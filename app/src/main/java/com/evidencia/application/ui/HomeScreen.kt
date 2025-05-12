package com.evidencia.application.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evidencia.application.R
import com.evidencia.application.ui.theme.EmeraldGreen

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Banner
            Image(
                painter = painterResource(id = R.drawable.img_one),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Introducción
            Text(
                text = "Descubre la Belleza Natural de Nuestros Jabones Artesanales",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Cada producto es elaborado con esmero, combinando aromas envolventes y beneficios para la salud, para ofrecerte una experiencia única de cuidado personal. Explora nuestra colección y transforma tu día a día en un momento de bienestar.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(35.dp))

            // Insignias
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                FeatureIcon(Icons.Default.CheckCircle, "Artesanal")
                FeatureIcon(Icons.Default.Favorite, "Natural")
                FeatureIcon(Icons.Default.CheckCircle, "Ecológico")
                FeatureIcon(Icons.Default.Favorite, "Mascotas")
            }

            Spacer(modifier = Modifier.height(45.dp))

            // Valores
            Text(
                text = "Conoce Nuestros Valores",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                InfoCard(
                    "Calidad garantizada",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae massa dictum, venenatis lectus at, pulvinar elit. Proin auctor tristique erat vel vulputate. Nam non lectus luctus, iaculis nisl sagittis."
                )
                InfoCard(
                    "Respeto por la naturaleza",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae massa dictum, venenatis lectus at, pulvinar elit. Proin auctor tristique erat vel vulputate. Nam non lectus luctus, iaculis nisl sagittis."
                )
                InfoCard(
                    "Cuidado para todos",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae massa dictum, venenatis lectus at, pulvinar elit. Proin auctor tristique erat vel vulputate. Nam non lectus luctus, iaculis nisl sagittis."
                )
                InfoCard(
                    "Amor por los animales",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae massa dictum, venenatis lectus at, pulvinar elit. Proin auctor tristique erat vel vulputate. Nam non lectus luctus, iaculis nisl sagittis."
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
        }
        Footer()
    }
}

@Composable
fun FeatureIcon(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 18.sp, fontStyle = FontStyle.Italic)
    }
}

@Composable
fun InfoCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = EmeraldGreen
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
