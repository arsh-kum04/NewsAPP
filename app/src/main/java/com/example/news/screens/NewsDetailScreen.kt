import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.news.R
import com.example.news.data.models.Article


@Composable
fun NewsDetailScreen(article: Article) {
    var isFavourite by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
//        AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(article.url)
//                    .crossfade(true)
//                    .build(),
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(250.dp)
//                    .clip(RoundedCornerShape(8.dp))
//                    .padding(bottom = 16.dp)
//        )
        Row(modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            article.title?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f)
                )
            }
            IconButton(
                onClick = { isFavourite = !isFavourite }
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isFavourite) R.drawable.save_button else R.drawable.baseline_add_24
                    ),
                    contentDescription = "Favorite Icon",
                )
            }
        }

        Text(
            text = "By ${article.author}",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        article.description?.let {
            Text(
                text = it,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
