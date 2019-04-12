using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Schedule
    {
        [Key]
        public int id_Schedule { get; set; }

        [Display(Name = "startDate")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime start_Date { get; set; }

        [Display(Name = "EndDate")]
        [Required(ErrorMessage = "Field {0} is required")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime end_Date { get; set; }

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

        public int id_Ambience { get; set; }
        public virtual Ambience ambience { get; set; }

        public int id_Modality { get; set; }
        public virtual Modality modality { get; set; }

        public int id_Version { get; set; }
        public virtual Version version { get; set; }

        public int idInstructor { get; set; }
        public virtual Instructor instructor { get; set; }

        public int id_Trimester { get; set; }
        public virtual Trimester trimester{ get; set; }

        public int id_Ficha { get; set; }
        public virtual  Ficha ficha { get; set; }

    }
}