package fpoly.giapdqph34273.asm_ph34273_kot104.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.giapdqph34273.asm_ph34273_kot104.R
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen.HomeScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.available.RouteNameScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen.FavouriteScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen.NotificationScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen.ProfileScreen

@Preview(showBackground = true)
@Composable
fun MyBottombar(navCtrl: NavController? = null) {

    val navController = rememberNavController()

    val selected = remember { mutableStateOf(RouteNameScreen.Home.route) }

    Scaffold(
        bottomBar = {
            // custom bottombar
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .height(100.dp)
            ) {

                // home
                IconButton(
                    onClick = {
                        selected.value = RouteNameScreen.Home.route
                        navController.navigate(RouteNameScreen.Home.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Image(
                        painter = painterResource(id = if (selected.value == RouteNameScreen.Home.route) R.drawable.black_home_icon else R.drawable.home_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                // favorite
                IconButton(
                    onClick = {
                        selected.value = RouteNameScreen.Favorite.route
                        navController.navigate(RouteNameScreen.Favorite.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == RouteNameScreen.Favorite.route) R.drawable.black_favourite_icon else R.drawable.favourite_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = RouteNameScreen.Notification.route
                        navController.navigate(RouteNameScreen.Notification.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == RouteNameScreen.Notification.route) R.drawable.black_notification_icon else R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = RouteNameScreen.Profile.route
                        navController.navigate(RouteNameScreen.Profile.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == RouteNameScreen.Profile.route) R.drawable.black_profile_icon else R.drawable.profile_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
            }
            // sử dụng navHostController đc tạo bởi remember

        }
    ) {
        NavHost(
            navController = navController,
            // navController trong navHost sẽ nhận navHost tạo ra từ remember,
            // còn ở trong màn home sẽ nhận navCtr (NavController)
            // tóm lại, các item của bottom đều sẽ nhận navHost, Home khác biệt sẽ nhận navCtr
            startDestination = RouteNameScreen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(RouteNameScreen.Home.route) {
                HomeScreen(navCtrl)
            }
            // Home sử dụng navCtrl là controller từ navControlller
            composable(RouteNameScreen.Favorite.route) {
                FavouriteScreen()
            }
            composable(RouteNameScreen.Notification.route) {
                NotificationScreen()
            }
            composable(RouteNameScreen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}