package com.example.bnews.src.ui.home

import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.culture.Row
import com.example.bnews.src.main.models.education.Education

interface EventFragmentView {


    fun onGetCultureEventSuccess(response: PublicReservationCulture)
    fun onCellClickListenerCultureEvent(response: Row)

    fun onGetEducationEventSuccess(response: Education)
    fun onCellClickListenerEducationEvent(response: com.example.bnews.src.main.models.education.Row)


}