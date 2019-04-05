using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class LevelTraining
    {
        [Key]
        [Column(Order = 6)]
        public int IDLevel { get; set; }
        [Display(Name = "Code LeveTraining")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string code { get; set; }
        [Display(Name = "state")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public bool state { get; set; }
        [StringLength(100)]
        [Display(Name ="Description")]
        public string description { get; set; }


        [Display(Name = "state")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public int IDinitials { get; set; }
        [ForeignKey("IDinitials")]
        public WorkingDay WorkingDay { get; set; }


    }
}