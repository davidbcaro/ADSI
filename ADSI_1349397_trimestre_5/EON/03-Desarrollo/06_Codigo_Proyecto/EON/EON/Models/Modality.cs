using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Modality
    {
        [Key]
        [Display(Name = "idModality")]
        public int id_Modality { get; set; }

        [Display(Name = "modalityName")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string modality_Name { get; set; }


        [Display(Name = "State")]
        public bool State { get; set; }

       public virtual ICollection<Schedule> schedule { get; set; }
    }
}