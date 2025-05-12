package com.evidencia.application.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.evidencia.application.R
import com.evidencia.application.ui.theme.EmeraldGreen

data class CompanyValue(val description: String, @DrawableRes val imageRes: Int)

@Composable
fun InfoScreen() {
    val values = listOf(
        CompanyValue("Respeto por la biodiversidad", R.drawable.img_two),
        CompanyValue("Conexión con la naturaleza", R.drawable.img_two),
        CompanyValue("Compromiso profesional", R.drawable.img_two)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "¿Quiénes somos?",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Itaque explicabo repellat fuga dolorum sed architecto, est eligendi voluptas? Aut nihil quas laborum praesentium et quo saepe, vitae sunt sint rem delectus recusandae perferendis illum tenetur fuga, molestiae sapiente iure debitis quidem. Ipsam aut quidem soluta quos quibusdam adipisci, repudiandae dicta!",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Misión
            Text(
                text = "Misión".uppercase(),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam veritatis odio impedit velit hic repellat ipsam accusamus sint, pariatur accusantium, corrupti obcaecati deserunt quasi voluptates. Porro ex ullam cum nobis.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Visión
            Text(
                text = "Visión".uppercase(),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quam veritatis odio impedit velit hic repellat ipsam accusamus sint, pariatur accusantium, corrupti obcaecati deserunt quasi voluptates. Porro ex ullam cum nobis.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Valores
            Text(
                text = "Nuestros Valores",
                style = MaterialTheme.typography.titleLarge,
                color = EmeraldGreen
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                values.forEach { value -> ValueItem(value) }
            }

            Spacer(modifier = Modifier.height(65.dp))
        }
        Footer()
    }
}

@Composable
fun ValueItem(companyValue: CompanyValue) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp)
    ) {
        Image(
            painter = painterResource(id = companyValue.imageRes),
            contentDescription = companyValue.description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = companyValue.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic
        )
    }
}
