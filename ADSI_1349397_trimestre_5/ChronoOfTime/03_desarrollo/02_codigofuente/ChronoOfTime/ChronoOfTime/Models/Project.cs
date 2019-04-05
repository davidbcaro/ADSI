using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Project
    {
        [Key]
        public int IDProject { get; set; }

        [Display(Name = "Code")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int code { get; set; }

        [StringLength(100)]
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo Name es obligatorio")]
        public string name { get; set; }

        [Display(Name = "State")]
        [Required(ErrorMessage = "El campo State es obligatorio")]
        public bool state { get; set; }

        
        


    }
}