using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Phase
    {

        [Key]
        public int IDPhaseP { get; set; }

        [StringLength(100)]
        [Display(Name = "Name phase")]
        [Required(ErrorMessage = "El campo Name phase es obligatorio")]
        public string mame_phase { get; set; }

        [Display(Name = "State")]
        [Required(ErrorMessage = "El campo State es obligatorio")]
        public bool state { get; set; }

        //FOREIGN

        [Display(Name = "Project")]
        [Required(ErrorMessage = "El campo Project es obligatorio")]
        public int code { get; set; }
        [ForeignKey("code")]
        public Project Project { get; set; }

       

        
    







    }
}