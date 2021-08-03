package com.project.pokedex.views.widgets

import android.content.Context
import android.media.Image
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.project.pokedex.R

class EmptyListWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0 , defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init{
        inflate(context, R.layout.empty_list_widget , this)

        val textViewEmpty: TextView = findViewById(R.id.textViewWidgetEmpty)
        val imageEmptyLust: ImageView = findViewById(R.id.imageViewWidgetEmpty)


        attrs?.let {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs ,
                R.styleable.EmptyListWidget,
                defStyleAttr ,
                defStyleRes
            )

            textViewEmpty.text = typedArray.getString(R.styleable.EmptyListWidget_text_descritption)

            imageEmptyLust.setImageDrawable(typedArray.getDrawable(R.styleable.EmptyListWidget_image_description))
        }
    }

}