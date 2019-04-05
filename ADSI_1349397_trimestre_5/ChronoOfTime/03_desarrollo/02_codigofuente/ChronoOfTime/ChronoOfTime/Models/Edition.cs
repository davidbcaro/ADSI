using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Edition
    {
        [Key]
        [Column(Order = 19)]
        public int IDEdition { get; set; }

        [Display(Name = "Edition")]
        [Required(ErrorMessage = "El campo Edition es obligatorio")]
        public int edition { get; set; }

        //[Display(Name = "Trimester Term")]
        //[Required(ErrorMessage = "El campo Trimester Term es obligatorio")]
       // public int IDTrimesterTerm { get; set; }
       // public virtual TrimesterTerm trimesterTerm { get; set; }

        //public virtual ICollection<Timetable> Timetables { get; set; }

        
    }
}