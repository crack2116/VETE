package com.proyecto.vetes.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.proyecto.vetes.data.VetDatabase

@Composable
fun HomeScreen(
    onNavigateToInventory: () -> Unit,
    onNavigateToSales: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        
        // Logo/Header
        Text(
            text = "🐾 VetES",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Text(
            text = "Sistema de Gestión Veterinaria",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Menu Cards
        MenuCard(
            title = "Inventario",
            subtitle = "Gestionar productos y stock",
            icon = "📦",
            color = MaterialTheme.colorScheme.primary,
            onClick = onNavigateToInventory
        )
        
        MenuCard(
            title = "Ventas",
            subtitle = "Registrar y ver ventas",
            icon = "💰",
            color = MaterialTheme.colorScheme.tertiary,
            onClick = onNavigateToSales
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Text(
            text = "Versión 1.0",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun MenuCard(
    title: String,
    subtitle: String,
    icon: String,
    color: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.1f)
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                fontSize = 48.sp,
                modifier = Modifier.padding(end = 20.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Text(
                text = "›",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}

