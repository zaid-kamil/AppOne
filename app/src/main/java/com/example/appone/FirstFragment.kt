package com.example.appone

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appone.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /* OnCreateOptionsMenu
    * used to connect the xml menu file to code and allow the menu to be displayed
    * */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_one, menu)
    }

    /* OnOptionsitemSelected
    * this allws us to handle what will happen on click of menu item
    * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_contact -> {
                Snackbar.make(binding.root, "please contact admin", Snackbar.LENGTH_LONG).show()
            }
            R.id.action_help -> {
                Snackbar.make(
                    binding.root,
                    "God helps those, that help themselves",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            R.id.action_rate -> {
                Snackbar.make(binding.root, "Not available yet", Snackbar.LENGTH_LONG).show()
            }
        }
        return true
    }
}