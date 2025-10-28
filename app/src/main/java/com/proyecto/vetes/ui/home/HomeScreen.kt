package com.proyecto.vetes.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onNavigateToInventory: () -> Unit,
    onNavigateToSales: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F5E9),
                        Color.White
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            
            // Header moderno
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF4CAF50),
                                Color(0xFF81C784)
                            )
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🐾",
                        fontSize = 72.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "VetES",
                        fontSize = 42.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Gestión Veterinaria",
                        fontSize = 16.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            // Menu Cards mejorados
            ModernMenuCard(
                title = "Inventario",
                subtitle = "Gestiona productos y controla el stock",
                icon = "📦",
                gradientStart = Color(0xFF4CAF50),
                gradientEnd = Color(0xFF66BB6A),
                onClick = onNavigateToInventory
            )
            
            Spacer(modifier = Modifier.height(20.dp))
            
            ModernMenuCard(
                title = "Ventas",
                subtitle = "Registra ventas y visualiza ingresos",
                icon = "💰",
                gradientStart = Color(0xFF81C784),
                gradientEnd = Color(0xFF4CAF50),
                onClick = onNavigateToSales
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "© 2024 VetES v1.0",
                fontSize = 12.sp,
                color = Color.Gray.copy(alpha = 0.6f),
                fontWeight = FontWeight.Light
            )
            
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ModernMenuCard(
    title: String,
    subtitle: String,
    icon: String,
    gradientStart: Color,
    gradientEnd: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable { onClick() }
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(25.dp),
                spotColor = gradientStart.copy(alpha = 0.3f)
            ),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            // Gradiente de fondo
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(120.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(gradientStart, gradientEnd)
                        ),
                        shape = RoundedCornerShape(start = 25.dp, end = 0.dp)
                    )
            )
            
            // Contenido
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    // Icono circular
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        gradientStart.copy(alpha = 0.2f),
                                        Color.Transparent
                                    )
                                ),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = icon,
                            fontSize = 40.sp
                        )
                    }
                    
                    Column {
                        Text(
                            text = title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = gradientStart
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = subtitle,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                
                // Flecha
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = gradientStart.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "›",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = gradientStart
                    )
                }
            }
        }
    }
}
