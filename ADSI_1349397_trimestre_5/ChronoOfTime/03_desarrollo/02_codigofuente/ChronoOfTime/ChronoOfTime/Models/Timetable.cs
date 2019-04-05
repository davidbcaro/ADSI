using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Timetable
    {
        [Key]
        [Column(Order = 24)]
        public int IDTimetable { get; set; }

        [DisplayFormat(DataFormatString = "{yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime startDate { get; set; }
        public DateTime endDate { get; set; }

      

    }
}