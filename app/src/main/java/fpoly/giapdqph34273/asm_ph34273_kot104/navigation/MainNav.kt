package fpoly.giapdqph34273.asm_ph34273_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.bottom_screen.HomeScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.available.RouteNameScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.BoardingScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.CartScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.CheckOutScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.CongratsScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.LoginScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.ProductDetailScreen
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screens.main_screen.SignUpScreen

//  ở biểu đồ navigation chính sẽ truyền đi navController, thực tế là con của NavHostController
// tiếp đó, navHost sẽ nhận navController và sẽ điều hướng các màn hình thông qua navController
// màn hình được hiển thị đầu tiên sẽ là màn hình Boarding(là màn hình chào)

// RouteNameScreen ở đây là enum class chứa tên các route có trong ứng dụng,
// toàn bộ nằm ở đó chứ k hề phân chia ra route name bottom hay route name main


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteNameScreen.Boarding.route,
    ) {

        composable(RouteNameScreen.Boarding.route) { BoardingScreen(navController) }
        composable(RouteNameScreen.Login.route) { LoginScreen(navController) }
        composable(RouteNameScreen.SignUp.route) { SignUpScreen(navController) }

        composable(RouteNameScreen.MyBottombar.route) { MyBottombar(navController) }

        // các màn hình k liên quan đến bottom navigation
        composable(RouteNameScreen.ProductDetail.route) { ProductDetailScreen(navController) }
        composable(RouteNameScreen.Cart.route) { CartScreen(navController) }
        composable(RouteNameScreen.CheckOut.route) { CheckOutScreen(navController) }
        composable(RouteNameScreen.Congrats.route) { CongratsScreen(navController) }

    }
}