package fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fpoly.giapdqph34273.asm_ph34273_kot104.R
import fpoly.giapdqph34273.asm_ph34273_kot104.available.RouteNameScreen

data class ProductModel(val name: String, val image: Int, val price: Float)

val productList = listOf(
    ProductModel("Chair", R.drawable.lamp, 100f),
    ProductModel("Table", R.drawable.minimalstand, 200f),
    ProductModel("Armchair", R.drawable.desk, 300f),
    ProductModel("Bed", R.drawable.chair, 400f),
    ProductModel("Lamp", R.drawable.lamp, 500f),
    ProductModel("Chair", R.drawable.chair, 100f)
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController? = null) {
    val navController = navController ?: rememberNavController()
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        content = {
            Content(navController)
        }
    )
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .background(Color("#fefefe".toColorInt()))
            .fillMaxWidth()
            .padding(start = 16.dp, top = 30.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { /* Handle search click */ }) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "search_icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Make home",
                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                fontWeight = FontWeight(400),
                fontSize = 18.sp,
                color = Color("#909090".toColorInt())
            )
            Text(
                text = "BEAUTIFUL",
                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                fontWeight = FontWeight(700),
                fontSize = 18.sp,
                color = Color("#242424".toColorInt())
            )
        }

        IconButton(onClick = {
            navController.navigate(RouteNameScreen.Cart.route)
        }) {
            Image(
                painter = painterResource(id = R.drawable.cart_icon),
                contentDescription = "cart_icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun Content(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color("#fefefe".toColorInt()))
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TypeList()
        ProductGrid(navController)
    }
}

@Composable
fun ProductGrid(navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 16.dp, top = 25.dp, end = 16.dp, bottom = 16.dp)
    ) {
        items(productList) { model ->
            ProductItem(model, navController)
        }
    }
}

@Composable
fun ProductItem(model: ProductModel, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier.clickable {
                navController.navigate(RouteNameScreen.ProductDetail.route)
            }
        ) {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = model.name,
                modifier = Modifier.size(200.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.addtocart),
                contentDescription = "add_to_cart",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .align(Alignment.Start)
        ) {
            Text(
                text = model.name,
                color = Color("#606060".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(400),
                fontSize = 14.sp
            )
            Text(
                text = "$${model.price}",
                color = Color("#303030".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(700),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun TypeList() {
    val scrollState = rememberScrollState()

    data class Item(val name: String, val imageId: Int)

    val images = listOf(
        Item("Popular", R.drawable.star_icon),
        Item("Chair", R.drawable.chair_icon),
        Item("Table", R.drawable.table_icon),
        Item("Armchair", R.drawable.armchair_icon),
        Item("Bed", R.drawable.bed_icon),
        Item("Lamp", R.drawable.lamp_icon)
    )

    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        images.forEachIndexed { index, item ->
            Button(
                onClick = { /* Handle filter click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                if (index == 0) Color("#303030".toColorInt()) else Color("#F5F5F5".toColorInt()),
                                RoundedCornerShape(12.dp)
                            )
                            .size(44.dp)
                    ) {
                        Image(
                            painter = painterResource(id = item.imageId),
                            contentDescription = item.name,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Text(
                        text = item.name,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = if (index == 0) Color("#242424".toColorInt()) else Color("#808080".toColorInt())
                    )
                }
            }
        }
    }
}
