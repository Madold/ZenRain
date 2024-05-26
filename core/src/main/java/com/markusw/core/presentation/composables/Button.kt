package com.markusw.core.presentation.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.markusw.core.R
import com.markusw.core.presentation.theme.spacing
import androidx.compose.material3.Button as MaterialButton

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    trailingIcon : @Composable (() -> Unit) = {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = stringResource(id = R.string.arrow_right)
        )
    },
    content: @Composable RowScope.() -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val buttonScale by animateFloatAsState(targetValue = if (isPressed) 0.95f else 1f, label = "buttonScale")

    MaterialButton(
        onClick = onClick,
        modifier = modifier
            .scale(buttonScale),
        enabled = enabled,
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = 42.dp, vertical = 16.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
            trailingIcon()
        }
    }
}

@Preview
@Composable
internal fun ButtonPreview(modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO*/ }) {
        Text("Start")
    }
}