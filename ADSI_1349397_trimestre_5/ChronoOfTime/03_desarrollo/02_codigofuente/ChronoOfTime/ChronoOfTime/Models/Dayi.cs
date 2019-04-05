using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Dayi
    {
        [Key]
        [Column(Order = 20)]
        public int IDDayi { get; set; }

        [StringLength(10)]
        [Display(Name = "Day")]
        [Required(ErrorMessage = "El campo Day es obligatorio")]
        public string name { get; set; }

        [Display(Name = "State")]
        [Required(ErrorMessage = "El campo State es obligatorio")]
        public bool state { get; set; }

        


    }
}