package dev.eamoretti.appue.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import dev.eamoretti.appue.data.model.CountryModel

@Composable
fun CountryList(
    countries: List<CountryModel>,
    favoriteCountries: List<String>,
    onToggleFavorite: ((CountryModel) -> Unit)? = null
) {
    LazyColumn {
        items(countries) { country ->
            val isFavorite = favoriteCountries.contains(country.name)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(country.imageURL),
                        contentDescription = country.name,
                        modifier = Modifier.size(64.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = country.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Ranking FIFA: ${country.ranking}")
                    }
                    //Favorites
                    onToggleFavorite?.let {
                        IconButton(onClick = {
                            it(country)
                        }) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Filled.Star else Icons.Filled.FavoriteBorder,
                                contentDescription = "Favorito"
                            )
                        }
                    }
                }
            }
        }
    }
}
