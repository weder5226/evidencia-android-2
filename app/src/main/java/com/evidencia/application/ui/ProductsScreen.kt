package com.evidencia.application.ui

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.evidencia.application.R
import com.evidencia.application.ui.theme.EmeraldGreen
import com.evidencia.application.ui.theme.IntenseBlue

data class Product(
    val name: String,
    val description: String,
    val price: String,
    @DrawableRes val imageRes: Int
)

@Composable
fun ProductsScreen() {
    val context = LocalContext.current
    val products = listOf(
        Product(
            "Jabón Natural",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$7.000",
            R.drawable.product_one
        ),
        Product(
            "Shampoo Aloe",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$16.000",
            R.drawable.product_two
        ),
        Product(
            "Crema Natural",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$11.000",
            R.drawable.product_one
        ),
        Product(
            "Aceite Esencial",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$20.000",
            R.drawable.product_two
        ),
        Product(
            "Jabón Herbal",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$9.000",
            R.drawable.product_one
        ),
        Product(
            "Shampoo Baby",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$14.000",
            R.drawable.product_two
        ),
        Product(
            "Crema Herbal",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$15.00",
            R.drawable.product_one
        ),
        Product(
            "Aceite Aloe",
            "Lorem ipsum dolor sit amet consectetur adipiscing elit quisque faucibus ex sapien vitae.",
            "$12.000",
            R.drawable.product_two
        ),
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
                .padding(12.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Nuestros Productos",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Descubre nuestra línea de productos hechos con amor y respeto por la naturaleza.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            products.forEach { product ->
                ProductCard(product = product) {
                    Toast.makeText(context, "Elegiste: ${product.name}", Toast.LENGTH_SHORT).show()
                }
            }
            Spacer(modifier = Modifier.height(65.dp))
        }
        Footer()
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .height(200.dp)
                    .width(165.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 16.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.name.uppercase(),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = EmeraldGreen,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.bodyLarge,
                        color = IntenseBlue,
                        textAlign = TextAlign.End,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
