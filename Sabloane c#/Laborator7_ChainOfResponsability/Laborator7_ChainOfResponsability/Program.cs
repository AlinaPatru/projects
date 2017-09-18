using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_ChainOfResponsability
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee teamLeader = new TeamLeader();
            Employee projectLeader = new ProjectLeader();
            Employee departmentDirector = new DepartmentDirector();
            Employee developer = new Developer();

            VacationRequest vacationRequest = new VacationRequest(DateTime.Now, new DateTime(2017, 04, 18));

            developer.Supervisor = teamLeader;

            teamLeader.Supervisor = projectLeader;

            projectLeader.Supervisor = departmentDirector;

            Console.WriteLine(vacationRequest.GetNumberOfDaysOff());

            developer.ApplyVacation(vacationRequest);

            Console.Read();
        }
    }
}
