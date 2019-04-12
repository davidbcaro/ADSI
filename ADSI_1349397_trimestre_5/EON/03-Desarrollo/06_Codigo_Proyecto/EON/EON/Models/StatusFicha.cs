using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class StatusFicha
    {
        [Key]
        [Display(Name = "id_StatusFicha")]
        public int id_Status_Ficha { get; set; }

        [Display(Name = "NameState")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string name_State { get; set; }

        [Display(Name = "Status")]
        public bool Status { get; set; }


        public virtual ICollection<Ficha> Fichas { get; set; }
        
    }
}