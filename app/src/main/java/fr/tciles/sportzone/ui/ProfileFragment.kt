package fr.tciles.sportzone.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import fr.tciles.sportzone.R
import fr.tciles.sportzone.data.ProfileDataViewModel
import fr.tciles.sportzone.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileDataViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_profile, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.save_menu_item) {
            save()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    private fun save() {
        hideKeyboard()

        val strVma = binding.textInputVma.text.toString()

        if (strVma.isNotEmpty()) {
            viewModel.setVma(Integer.parseInt(strVma))
        }

        val strPma = binding.textInputPma.text.toString()

        if (strPma.isNotEmpty()) {
            viewModel.setPma(Integer.parseInt(strPma))
        }

        val strFtp = binding.textInputFtp.text.toString()

        if (strFtp.isNotEmpty()) {
            viewModel.setFtp(Integer.parseInt(strFtp))
        }

        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vma.observe(viewLifecycleOwner, Observer<Int> { vma ->
            binding.textInputVma.setText(vma.toString())
        })
        viewModel.pma.observe(viewLifecycleOwner, Observer<Int> { pma ->
            binding.textInputPma.setText(pma.toString())
        })
        viewModel.ftp.observe(viewLifecycleOwner, Observer<Int> { ftp ->
            binding.textInputFtp.setText(ftp.toString())
        })

        /*
        binding.textInputVma.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.textInputPma.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.textInputFtp.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {}
        })
         */
    }
}