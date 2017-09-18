using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_ChainOfResponsability
{
    class Developer:Employee
    {
        public override int GetMaxVacationDaysCanApprove()
        {
            return 0;
        }
    }
}
