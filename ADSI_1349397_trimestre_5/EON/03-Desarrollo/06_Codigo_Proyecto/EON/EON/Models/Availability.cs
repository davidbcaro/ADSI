using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Availability
    {
        [Key]
        [Display(Name = "idAvailability")]
        public int idAvailability { get; set; }

        [Display(Name = "Start Time")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        public System.DateTime Start_Time { get; set; }

        [Display(Name = "end Time")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Time)]
        [DisplayFormat(DataFormatString = "{0:HH:mm}", ApplyFormatInEditMode = true)]
        public System.DateTime End_Time { get; set; }

        [Display(Name = "idWorking")]
        public int id_working_Day { get; set; }
        public virtual workingDay workingDay { get; set; }


        [Display(Name = "Mon")]
        public bool Monday { get; set; }


        [Display(Name = "Tue")]
        public bool Tuesday { get; set; }


        [Display(Name = "Wed")]
        public bool Wednesday { get; set; }


        [Display(Name = "Thu")]
        public bool Thursday { get; set; }


        [Display(Name = "Fri")]
        public bool Friday { get; set; }


        [Display(Name = "Sat")]
        public bool Saturday { get; set; }

        [Display(Name = "Sun")]
        public bool Sunday { get; set; }





       
    }
}