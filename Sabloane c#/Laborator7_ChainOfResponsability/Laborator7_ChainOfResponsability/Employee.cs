using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_ChainOfResponsability
{
    abstract class Employee
    {
        public Employee Supervisor { get; set; }

        public void ApplyVacation(VacationRequest vacationRequest)
        {
            ApproveVacation(vacationRequest);
        }

        public bool ApproveVacation(VacationRequest vacationRequest)
        {
            if(vacationRequest.GetNumberOfDaysOff()<=GetMaxVacationDaysCanApprove())
            {
                Console.WriteLine("The request was approved by  "+this.GetType());
                return true;
            }
            else
            {
                if(Supervisor!=null)
                {
                    return Supervisor.ApproveVacation(vacationRequest);
                }
                else
                {
                    Console.WriteLine("The request wasn't approved");
                }
            }
            return false;
        }

        public abstract int GetMaxVacationDaysCanApprove();
    }
}
