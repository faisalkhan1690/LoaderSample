package com.example.faisalkhan.loadersample.asyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.faisalkhan.loadersample.R;

/**
 * Adapter class for loader data in list using AsyncTaskLoader
 *
 * For details how what is BaseAdapter follow link :-
 * https://developer.android.com/reference/android/widget/BaseAdapter.html
 *
 * For more details about adapters follow link :-
 * https://developer.android.com/reference/android/widget/Adapter.html
 *
 * @author Faisal Khan
 */
class EmployeeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Employee> employees = new ArrayList<>();

    EmployeeAdapter(Context context, List<Employee> employees) {
        this.employees = employees;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Employee emp = (Employee) getItem(position);
        if (view == null) {
            view = inflater.inflate(R.layout.employeedata, null);
        }
        TextView tvEmpId = (TextView) view.findViewById(R.id.empid);
        tvEmpId.setText(emp.empId);
        TextView tvEmpName = (TextView) view.findViewById(R.id.empname);
        tvEmpName.setText(emp.empName);
        return view;
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    /**
     * Method to set data in adapter list
     * @param data list of employee type data
     */
    void setEmployees(List<Employee> data) {
        employees.addAll(data);
        notifyDataSetChanged();
    }
}