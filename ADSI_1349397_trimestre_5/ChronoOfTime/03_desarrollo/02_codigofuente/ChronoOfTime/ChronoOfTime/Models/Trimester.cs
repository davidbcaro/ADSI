using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Trimester
    {
        [Key]
        [Column(Order = 3)]
        public int IDTrimester { get; set; }
        
        [Display(Name = "Number Trimester")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int numberTrimester { get; set; }

        [Display(Name = "State")]
        public bool state { get; set; }

      //FOREIGN

        [Display(Name = "Level trining")]
        [Required(ErrorMessage = "El campo Code es obligatorio")]
        public int  IDLevel { get; set; }
        [ForeignKey("IDLevel")]
        public LevelTraining LevelTraining { get; set; }

        [Display(Name ="Number Group")]
        [Required(ErrorMessage ="El campo {0} es obligatorio")]
        public int IDNumberGroup { get; set; }
        [ForeignKey("IDNumberGroup")]
        public NumberGroup NumberGroup { get; set; }




    }
}