package fr.tiucorps.propointscalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NutritionFragment.OnNutritionChangeListener} interface
 * to handle interaction events.
 * Use the {@link NutritionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NutritionFragment extends Fragment implements NutritionWatcher {

    private OnNutritionChangeListener mListener;

    ValueWatcher mLipidWatcher;
    ValueWatcher mGlucidWatcher;
    ValueWatcher mProteinWatcher;
    ValueWatcher mFiberWatcher;
    ValueWatcher mValueForWatcher;

    public NutritionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NutritionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NutritionFragment newInstance(String param1, String param2) {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutrition, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNutritionChangeListener) {
            mListener = (OnNutritionChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    // FORMULE : Lipides/4 + Glucides/9 + Protéines/11 + Fibres/30
    public void onValueChanged() {
        if(!mLipidWatcher.isValid || !mGlucidWatcher.isValid || !mProteinWatcher.isValid || !mValueForWatcher.isValid) {
            return;
        }

        float points = mLipidWatcher.value/4f + mGlucidWatcher.value/9f + mProteinWatcher.value/11f;
        if(mFiberWatcher.isValid) {
            points += mFiberWatcher.value/30;
        }

        if(mListener != null) {
            mListener.onNutritionChange(points, mValueForWatcher.value);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNutritionChangeListener {
        // TODO: Update argument type and name
        void onNutritionChange(float points, float forSize);
    }
}
