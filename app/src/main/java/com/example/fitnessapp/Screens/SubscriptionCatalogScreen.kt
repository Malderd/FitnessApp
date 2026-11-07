package com.example.fitnessapp.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.navigation.Destination
import com.example.fitnessapp.R

data class SubscriptionPlan(
    val id: Int,
    val name: String,
    val price: Int,
    val duration: String,
    val workoutsCount: String,
    val description: String,
    val features: List<String>
)

val subscriptionPlans = listOf(
    SubscriptionPlan(
        id = 1,
        name = "Безлимитный",
        price = 5000,
        duration = "30 дней",
        workoutsCount = "Без ограничений",
        description = "Посещайте фитнес-центр без ограничений в течение всего срока действия абонемента.",
        features = listOf(
            "Неограниченное количество посещений",
            "Доступ ко всем групповым тренировкам",
            "Посещение тренажёрного зала",
            "Доступ ко всем зонам фитнес-центра"
        )
    ),
    SubscriptionPlan(
        id = 2,
        name = "На 12 занятий",
        price = 3500,
        duration = "30 дней",
        workoutsCount = "12 занятий",
        description = "Абонемент для тех, кто предпочитает регулярно посещать тренировки несколько раз в неделю.",
        features = listOf(
            "12 посещений фитнес-центра",
            "Доступ к групповым тренировкам",
            "Посещение тренажёрного зала",
            "Срок действия — 30 дней"
        )
    ),
    SubscriptionPlan(
        id = 3,
        name = "На 8 занятий",
        price = 2500,
        duration = "30 дней",
        workoutsCount = "8 занятий",
        description = "Подойдёт тем, кто хочет заниматься в комфортном темпе и самостоятельно планировать посещения.",
        features = listOf(
            "8 посещений фитнес-центра",
            "Доступ к групповым тренировкам",
            "Посещение тренажёрного зала",
            "Срок действия — 30 дней"
        )
    ),
    SubscriptionPlan(
        id = 4,
        name = "На 4 занятия",
        price = 1500,
        duration = "30 дней",
        workoutsCount = "4 занятия",
        description = "Начальный вариант для знакомства с фитнес-центром и тренировками.",
        features = listOf(
            "4 посещения фитнес-центра",
            "Доступ к групповым тренировкам",
            "Посещение тренажёрного зала",
            "Срок действия — 30 дней"
        )
    )
)

@Composable
fun SubscriptionCatalogScreen(
    onSubscriptionClick: (Int) -> Unit,
    onNavigate: (String) -> Unit
) {
    PageScaffold(
        title = stringResource(R.string.subscription_catalog_title),
        currentRoute = Destination.SubscriptionCatalog.route,
        onNavigate = onNavigate
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
        ) {
            Text(
                text = stringResource(R.string.subscription_catalog_description),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(subscriptionPlans) { plan ->
                    SubscriptionCard(
                        plan = plan,
                        onClick = {
                            onSubscriptionClick(plan.id)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SubscriptionCard(
    plan: SubscriptionPlan,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CreditCard,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = plan.name,
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = plan.duration,
                    modifier = Modifier.padding(start = 8.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = plan.workoutsCount,
                    modifier = Modifier.padding(start = 6.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${plan.price} ₽",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(R.string.subscription_more_details),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}