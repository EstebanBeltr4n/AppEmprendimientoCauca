package com.example.appemprendimientocauca.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.appemprendimientocauca.R
import com.example.appemprendimientocauca.data.OrderUiState
import com.example.appemprendimientocauca.ui.theme.AppEmprendimientoCaucaTheme


@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources

    val numberOfCupcakes = resources.getQuantityString(
        orderUiState.quantity,
        orderUiState.quantity
    )
    //Load and format a string resource with the parameters.
    val orderSummary = stringResource(
        R.string.app_name,
        numberOfCupcakes,
        orderUiState.flavor,
        orderUiState.flavor,
        orderUiState.quantity
    )
    val newOrder = stringResource(R.string.app_name)
    //Create a list of order summary to display
    val items = listOf(
        // Summary line 1: display selected quantity
        Pair(stringResource(R.string.app_name), numberOfCupcakes),
        // Summary line 2: display selected flavor
        Pair(stringResource(R.string.app_name), orderUiState.flavor),
        // Summary line 3: display selected pickup date
        Pair(stringResource(R.string.app_name), orderUiState.flavor)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(androidx.appcompat.R.dimen.abc_action_bar_default_height_material)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(androidx.appcompat.R.dimen.abc_action_bar_default_height_material))
        ) {
            items.forEach { item ->
                Text(item.first.uppercase())
                Text(text = item.second, fontWeight = FontWeight.Bold)
                Divider(thickness = dimensionResource(androidx.appcompat.R.dimen.abc_action_bar_default_height_material))
            }

        }
        Row(
            modifier = Modifier.padding(dimensionResource(androidx.appcompat.R.dimen.abc_action_bar_default_height_material))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(androidx.appcompat.R.dimen.abc_action_bar_default_height_material))
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onSendButtonClicked(newOrder, orderSummary) }
                ) {
                    Text(stringResource(R.string.app_name))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(androidx.compose.ui.R.string.selected))
                }
            }
        }
    }
}

@Preview
@Composable
fun OrderSummaryPreview() {
    AppEmprendimientoCaucaTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Test", "Test", "$300.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}
