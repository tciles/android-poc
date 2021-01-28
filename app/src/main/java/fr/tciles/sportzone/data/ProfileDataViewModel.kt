package fr.tciles.sportzone.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileDataViewModel : ViewModel() {
    private val _vma = MutableLiveData(19)
    private val _pma = MutableLiveData(380)
    private val _ftp = MutableLiveData(300)

    val vma: LiveData<Int> = _vma
    val pma: LiveData<Int> = _pma
    val ftp: LiveData<Int> = _ftp

    fun setVma(value: Int) {
        if (value != _vma.value) {
            _vma.value = value
        }
    }

    fun setPma(value: Int) {
        if (value != _pma.value) {
            _pma.value = value
        }
    }

    fun setFtp(value: Int) {
        if (value != _ftp.value) {
            _ftp.value = value
        }
    }
}