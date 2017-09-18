using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator7_ChainOfResponsability
{
    class VacationRequest
    {
        private static int iLastRequestNumber=0;
        public DateTime StartDay { get; set; }
        public DateTime EndDay { get; set; }
        public int RequestNumber { get; set; }

        public VacationRequest(DateTime d1,DateTime d2)
        {
            StartDay = d1;
            EndDay = d2;
            RequestNumber = ++iLastRequestNumber;
        }

        public int GetNumberOfDaysOff()
        {
            return (EndDay - StartDay).Days;
        }
    }
}
